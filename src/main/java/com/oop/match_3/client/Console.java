package com.oop.match_3.client;

import com.oop.match_3.field.Coords;
import com.oop.match_3.field.CoordsADT;
import com.oop.match_3.gameplay.phases.Game;
import com.oop.match_3.gameplay.steps.FinishStep;
import com.oop.match_3.gameplay.steps.RestartStep;
import com.oop.match_3.gameplay.steps.SwapStep;
import com.oop.match_3.math.UnsignedInt;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Console {
    private static final int BOARD_HEIGHT = 8;
    private static final String COLUMN_HEADER = "  A B C D E F G H";
    private static final String RESET = "[0m";
    private static final Map<String, String> COLOR_BY_ELEMENT = Map.of(
        "A", "[31m",
        "B", "[32m",
        "C", "[33m",
        "D", "[34m",
        "E", "[35m"
    );

    private final Game game;
    private final Scanner scanner;

    public Console() {
        this.game = new Game();
        this.scanner = new Scanner(System.in);
    }

    public static void main(final String[] args) {
        new Console().run();
    }

    private void run() {
        printHelp();
        while (!game.isOver()) {
            advanceUntilInteractive();
            if (game.isOver()) {
                break;
            }
            printState();
            promptAndAct();
        }
        System.out.println("Игра завершена.");
    }

    private void advanceUntilInteractive() {
        while (!game.currentPhase().isInteractive() && !game.isOver()) {
            game.advance();
        }
    }

    private void printState() {
        String[] lines = game.print().split("\n", -1);
        System.out.println(COLUMN_HEADER);
        IntStream.range(0, BOARD_HEIGHT).forEach(i -> printBoardRow(i, lines[i]));
        IntStream.range(BOARD_HEIGHT, lines.length).forEach(i -> System.out.println(lines[i]));
        System.out.println();
    }

    private void printBoardRow(final int index, final String row) {
        System.out.printf("%d %s\n", index + 1, colorize(row));
    }

    private String colorize(final String row) {
        return Arrays.stream(row.split(" "))
            .map(this::colorizeToken)
            .collect(Collectors.joining(" "));
    }

    private String colorizeToken(final String token) {
        return COLOR_BY_ELEMENT.getOrDefault(token, "") + token + RESET;
    }

    private void promptAndAct() {
        System.out.print("> ");
        String input = scanner.nextLine().trim();
        handle(input);
    }

    private void handle(final String input) {
        if (isFinishCommand(input)) {
            game.accept(new FinishStep());
            return;
        }
        if (isRestartCommand(input)) {
            game.accept(new RestartStep());
            return;
        }
        handleSwap(input);
    }

    private boolean isFinishCommand(final String input) {
        return input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("q");
    }

    private boolean isRestartCommand(final String input) {
        return input.equalsIgnoreCase("restart") || input.equalsIgnoreCase("r");
    }

    private void handleSwap(final String input) {
        String[] parts = input.split("\\s+");
        if (parts.length != 2) {
            System.out.println("Неверный ввод. Введите 'A1 B1', 'restart' или 'exit'.");
            return;
        }
        CoordsADT first = parseCoords(parts[0]);
        CoordsADT second = parseCoords(parts[1]);
        if (first == null || second == null) {
            System.out.println("Неверные координаты. Используйте A1-H8.");
            return;
        }
        if (!first.isNeighbour(second)) {
            System.out.println("Ячейки должны быть соседними.");
            return;
        }
        game.accept(new SwapStep(first, second));
    }

    private CoordsADT parseCoords(final String token) {
        if (token.length() != 2) {
            return null;
        }
        char colChar = Character.toUpperCase(token.charAt(0));
        char rowChar = token.charAt(1);
        if (colChar < 'A' || colChar > 'H' || rowChar < '1' || rowChar > '8') {
            return null;
        }
        return new Coords(new UnsignedInt(colChar - 'A'), new UnsignedInt(rowChar - '1'));
    }

    private void printHelp() {
        System.out.println("""
        Команды:
          <A1> <B1>   — обмен соседними ячейками (A-H, 1-8)
          restart / r — начать заново (в конце игры)
          exit / q    — завершить
        """);
    }
}
