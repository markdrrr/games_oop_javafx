package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Возвращает массив ячеек, по которым будет двигаться фигура.
     *
     * @param source Начальная позиция фигуры.
     * @param dest   Конечная позиция фигуры.
     * @return Массив ячеек, по которым пройдет фигура.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX =  source.x;
        int deltaY = source.y;
        for (int index = 0; index < size; index++) {
            Cell[] cells = Cell.values();
            if (deltaX > dest.x && deltaY > dest.y) {
                deltaX--;
                deltaY--;
            } else if (deltaX < dest.x && deltaY > dest.y) {
                deltaX++;
                deltaY--;
            } else if (deltaX < dest.x && deltaY < dest.y) {
                deltaX++;
                deltaY++;
            } else {
                deltaX--;
                deltaY++;
            }
            for (Cell cell : cells) {
                if (cell.x == deltaX && cell.y == deltaY) {
                    steps[index] = cell;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * Проверяем диагональ.
     *
     * @param source Начальная точка.
     * @param dest   Конечная точка.
     * @return Результат проверки.
     */
    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = Math.abs(dest.x - source.x);
        int deltaY = Math.abs(dest.y - source.y);
        if (deltaX == deltaY) {
            result = true;
        };
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}