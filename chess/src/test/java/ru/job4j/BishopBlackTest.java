package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bioshop = new BishopBlack(Cell.B1);
        assertThat(bioshop.position(), is(Cell.B1));
    }

    @Test
    public void copy() {
        BishopBlack bioshop = new BishopBlack(Cell.B1);
        assertThat(bioshop.copy(Cell.C2).position(), is(Cell.C2));
    }

    @Test
    public void way() {
        BishopBlack bioshop = new BishopBlack(Cell.C1);
        Cell[] result = bioshop.way(Cell.C1, G5);
        Cell[] expected = {D2,E3,F4,G5};
        assertThat(result, is(expected));
    }

    @Test
    public void isDiagonal(){
        BishopBlack bioshop = new BishopBlack(Cell.C1);
        boolean result = bioshop.isDiagonal(C1, G5);
        boolean expected = true;
        assertThat(result, is(expected));
    }
}
