package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Grid extends GridADT {
    private static final int SIZE = 8;
    private static final int CELLS_COUNT = SIZE * SIZE;
    private static final int MIN_COMBO_LENGTH = 3;
    private static final CellADT EMPTY = new Cell(new Coords(new UnsignedInt(0), new UnsignedInt(0)), Element.NONE);

    private final List<CellADT> cells;
    private final ElementsFactoryADT factory;

    private int swapStatus;

    public Grid(final ElementsFactoryADT factory) {
        super(factory);
        this.factory = factory;
        this.cells = build();
        this.swapStatus = SWAP_OK;
    }

    @Override
    public Combo[] combos() {
        return combosOf(cells);
    }

    @Override
    public boolean isStable() {
        return combos().length == 0;
    }

    @Override
    public boolean hasMoves() {
        return hasMovesIn(cells);
    }

    @Override
    public String print() {
        return IntStream.range(0, SIZE)
            .mapToObj(this::printRow)
            .collect(Collectors.joining("\n"));
    }

    @Override
    public void swap(final CoordsADT first, final CoordsADT second) {
        if (outOfBounds(first) || outOfBounds(second)) {
            swapStatus = SWAP_OUT_OF_BOUNDS;
            return;
        }
        if (!first.isNeighbour(second)) {
            swapStatus = SWAP_NOT_NEIGHBOURS;
            return;
        }
        cellAt(first).swap(cellAt(second));
        swapStatus = SWAP_OK;
    }

    @Override
    public void resolve(final Combo[] combos) {
        Arrays.stream(combos).forEach(Combo::clear);
    }

    @Override
    public void gravity() {
        IntStream.range(0, SIZE).forEach(this::applyGravityTo);
    }

    @Override
    public void refill() {
        cells.stream()
            .filter(this::isEmpty)
            .forEach(cell -> cell.assignElement(factory.generate()));
    }

    @Override
    public int getSwapStatus() {
        return swapStatus;
    }

    private String printRow(final int row) {
        return IntStream.range(0, SIZE)
            .mapToObj(col -> cellAt(newCoords(col, row)).print())
            .collect(Collectors.joining(" "));
    }

    private boolean outOfBounds(final CoordsADT target) {
        return cells.stream().noneMatch(cell -> cell.isAt(target));
    }

    private CellADT cellAt(final CoordsADT target) {
        return cells.stream()
            .filter(cell -> cell.isAt(target))
            .findFirst()
            .orElseThrow();
    }

    private void applyGravityTo(final int col) {
        IntStream.range(0, SIZE - 1).forEach(pass -> bubbleColumn(col));
    }

    private void bubbleColumn(final int col) {
        IntStream.range(0, SIZE - 1).forEach(upper -> bubbleAt(col, upper));
    }

    private void bubbleAt(final int col, final int upperRow) {
        CellADT upper = cellAt(newCoords(col, upperRow));
        CellADT lower = cellAt(newCoords(col, upperRow + 1));
        dropIfNeeded(upper, lower);
    }

    private void dropIfNeeded(final CellADT upper, final CellADT lower) {
        if (shouldDrop(upper, lower)) {
            upper.swap(lower);
        }
    }

    private boolean shouldDrop(final CellADT upper, final CellADT lower) {
        return isEmpty(lower) && !isEmpty(upper);
    }

    private boolean isEmpty(final CellADT cell) {
        return cell.hasSameElementAs(EMPTY);
    }

    private Combo[] combosOf(final List<CellADT> source) {
        List<List<CellADT>> horizontals = qualifyingRuns(rows(source));
        List<List<CellADT>> verticals = qualifyingRuns(columns(source));
        return combos(horizontals, verticals).toArray(new Combo[0]);
    }

    private List<List<CellADT>> qualifyingRuns(final List<List<CellADT>> lines) {
        return lines.stream()
            .map(this::runs)
            .flatMap(List::stream)
            .filter(this::isCombo)
            .collect(Collectors.toList());
    }

    private List<Combo> combos(final List<List<CellADT>> horizontals, final List<List<CellADT>> verticals) {
        List<Combo> combos = new ArrayList<>(crossCombos(horizontals, verticals));
        combos.addAll(linearCombos(horizontals, verticals));
        return combos;
    }

    private List<Combo> crossCombos(final List<List<CellADT>> horizontals, final List<List<CellADT>> verticals) {
        return horizontals.stream()
            .flatMap(horizontal -> crossesOf(horizontal, verticals))
            .collect(Collectors.toList());
    }

    private Stream<Combo> crossesOf(final List<CellADT> horizontal, final List<List<CellADT>> verticals) {
        return verticals.stream()
            .filter(vertical -> isCross(horizontal, vertical))
            .map(vertical -> crossCombo(horizontal, vertical));
    }

    private Combo crossCombo(final List<CellADT> horizontal, final List<CellADT> vertical) {
        return new CrossCombo(toArray(union(horizontal, vertical)));
    }

    private List<Combo> linearCombos(final List<List<CellADT>> horizontals, final List<List<CellADT>> verticals) {
        List<List<CellADT>> all = new ArrayList<>(horizontals);
        all.addAll(verticals);
        return all.stream()
            .filter(run -> isLinear(run, all))
            .map(run -> new LinearCombo(toArray(run)))
            .collect(Collectors.toList());
    }

    private boolean isLinear(final List<CellADT> run, final List<List<CellADT>> all) {
        return all.stream().noneMatch(other -> isCrossPair(run, other));
    }

    private boolean isCrossPair(final List<CellADT> run, final List<CellADT> other) {
        return run != other && isCross(run, other);
    }

    private boolean isCross(final List<CellADT> first, final List<CellADT> second) {
        return isOddLength(first) && isOddLength(second) && sameCenter(first, second);
    }

    private boolean isOddLength(final List<CellADT> run) {
        return run.size() % 2 == 1;
    }

    private boolean sameCenter(final List<CellADT> first, final List<CellADT> second) {
        return center(first) == center(second);
    }

    private CellADT center(final List<CellADT> run) {
        return run.get(run.size() / 2);
    }

    private List<List<CellADT>> rows(final List<CellADT> source) {
        return IntStream.range(0, SIZE)
            .mapToObj(i -> row(source, i))
            .collect(Collectors.toList());
    }

    private List<List<CellADT>> columns(final List<CellADT> source) {
        return IntStream.range(0, SIZE)
            .mapToObj(i -> column(source, i))
            .collect(Collectors.toList());
    }

    private List<CellADT> row(final List<CellADT> source, final int row) {
        return source.subList(row * SIZE, row * SIZE + SIZE);
    }

    private List<CellADT> column(final List<CellADT> source, final int col) {
        return IntStream.range(0, SIZE)
            .mapToObj(row -> source.get(row * SIZE + col))
            .collect(Collectors.toList());
    }

    private List<List<CellADT>> runs(final List<CellADT> line) {
        List<List<CellADT>> runs = new ArrayList<>();
        line.forEach(cell -> appendToRuns(runs, cell));
        return runs;
    }

    private void appendToRuns(final List<List<CellADT>> runs, final CellADT cell) {
        if (startsNewRun(runs, cell)) {
            runs.add(new ArrayList<>());
        }
        lastRun(runs).add(cell);
    }

    private boolean startsNewRun(final List<List<CellADT>> runs, final CellADT cell) {
        if (runs.isEmpty()) {
            return true;
        }
        return !lastCell(runs).hasSameElementAs(cell);
    }

    private CellADT lastCell(final List<List<CellADT>> runs) {
        List<CellADT> run = lastRun(runs);
        return run.getLast();
    }

    private List<CellADT> lastRun(final List<List<CellADT>> runs) {
        return runs.getLast();
    }

    private boolean isCombo(final List<CellADT> run) {
        return isLongEnough(run) && isPlayable(run);
    }

    private boolean isLongEnough(final List<CellADT> run) {
        return run.size() >= MIN_COMBO_LENGTH;
    }

    private boolean isPlayable(final List<CellADT> run) {
        return !run.getFirst().hasSameElementAs(EMPTY);
    }

    private List<CellADT> union(final List<CellADT> first, final List<CellADT> second) {
        return Stream.concat(first.stream(), second.stream())
            .distinct()
            .toList();
    }

    private CellADT[] toArray(final List<CellADT> cells) {
        return cells.toArray(new CellADT[0]);
    }

    private List<CellADT> build() {
        List<CellADT> candidate = randomCells();
        while (!isStartable(candidate)) {
            candidate = randomCells();
        }
        return candidate;
    }

    private boolean isStartable(final List<CellADT> candidate) {
        return combosOf(candidate).length == 0 && hasMovesIn(candidate);
    }

    private boolean hasMovesIn(final List<CellADT> source) {
        return neighbourPairs().anyMatch(pair -> swapCreatesCombo(source, pair));
    }

    private Stream<int[]> neighbourPairs() {
        return Stream.concat(horizontalPairs(), verticalPairs());
    }

    private Stream<int[]> horizontalPairs() {
        return IntStream.range(0, SIZE).boxed().flatMap(this::horizontalPairsInRow);
    }

    private Stream<int[]> horizontalPairsInRow(final Integer row) {
        return IntStream.range(0, SIZE - 1)
            .mapToObj(col -> indexPair(row, col, row, col + 1));
    }

    private Stream<int[]> verticalPairs() {
        return IntStream.range(0, SIZE).boxed().flatMap(this::verticalPairsInColumn);
    }

    private Stream<int[]> verticalPairsInColumn(final Integer col) {
        return IntStream.range(0, SIZE - 1)
            .mapToObj(row -> indexPair(row, col, row + 1, col));
    }

    private int[] indexPair(final int r1, final int c1, final int r2, final int c2) {
        return new int[]{r1 * SIZE + c1, r2 * SIZE + c2};
    }

    private boolean swapCreatesCombo(final List<CellADT> source, final int[] pair) {
        source.get(pair[0]).swap(source.get(pair[1]));
        boolean produced = combosOf(source).length > 0;
        source.get(pair[0]).swap(source.get(pair[1]));
        return produced;
    }

    private List<CellADT> randomCells() {
        return IntStream.range(0, CELLS_COUNT)
            .mapToObj(i -> new Cell(newCoords(i % SIZE, i / SIZE), factory.generate()))
            .collect(Collectors.toList());
    }

    private CoordsADT newCoords(final int col, final int row) {
        return new Coords(new UnsignedInt(col), new UnsignedInt(row));
    }
}
