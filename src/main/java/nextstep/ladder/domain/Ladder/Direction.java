package nextstep.ladder.domain.Ladder;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("Direction 은 양쪽 방향을 가질 수 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public Direction next(final boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction last() {
        return of(this.right, false);
    }

    public static Direction of(final boolean left, final boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(final boolean right) {
        return of(false, right);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        final Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
