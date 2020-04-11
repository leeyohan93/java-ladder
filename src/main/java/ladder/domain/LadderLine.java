package ladder.domain;

import ladder.util.RandomUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {
    private final List<LadderLink> ladderLinks;

    public static LadderLine of(int userCount) {
        return new LadderLine(Stream.iterate(LadderLink.DIS_CONNECT,
                ladderLink -> LadderLink.of(ladderLink, RandomUtil::nextBoolean))
                .limit(userCount)
                .collect(Collectors.toList()));
    }

    public static LadderLine of(List<LadderLink> ladderLinks) {
        return new LadderLine(ladderLinks);
    }

    private LadderLine(List<LadderLink> ladderLinks) {
        this.ladderLinks = Collections.unmodifiableList(ladderLinks);
    }

    public int getLinkCount() {
        return ladderLinks.size();
    }

    public List<LadderLink> getLadderLinks() {
        return ladderLinks;
    }

    public boolean isLinkConnect(Position position) {
        if (position.goe(ladderLinks.size())) {
            return false;
        }
        return ladderLinks.get(position.getPosition()) == LadderLink.CONNECT;
    }
}
