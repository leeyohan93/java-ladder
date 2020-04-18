package ladder.domain;

import java.util.Objects;

public class Point {
    private static final int INIT_INDEX = 0;

    private final Position position;
    private final Direction direction;

    public static Point first(boolean right) {
        return new Point(INIT_INDEX, Direction.first(right));
    }

    public Point(int position, Direction direction) {
        this(new Position(position), direction);
    }

    public Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position move() {
        if (direction.isRight()) {
            return position.right();
        }

        if (direction.isLeft()) {
            return position.left();
        }

        return position;
    }

    public Point next(boolean nextRight) {
        return new Point(position.right(), direction.next(nextRight));
    }

    public Point last() {
        return new Point(position.right(), direction.last());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Objects.equals(position, point.position) &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
