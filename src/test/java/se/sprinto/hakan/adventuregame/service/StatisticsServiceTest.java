package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.dao.FakeFileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class StatisticsServiceTest {
    @Test
    public void testGetSortedStatistics() {
        StatisticsDao dao = new FakeFileStatisticsDao();
        StatisticsService service = new StatisticsService(dao);

        List<Statistics> expectedList = new ArrayList<>(List.of(
                new Statistics("Martin", 210),
                new Statistics("Paveena", 150),
                new Statistics("Anwar", 108)
        ));

        List<Statistics> result = service.getSortedStatistics();

        Assertions.assertEquals(expectedList.size(), result.size());
        Assertions.assertEquals(expectedList.getFirst().getScore(), result.getFirst().getScore());
        Assertions.assertEquals(expectedList.getFirst().getPlayerName(), result.getFirst().getPlayerName());
        Assertions.assertEquals(expectedList.get(1).getScore(), result.get(1).getScore());
        Assertions.assertEquals(expectedList.get(1).getPlayerName(), result.get(1).getPlayerName());
        Assertions.assertEquals(expectedList.getLast().getScore(), result.getLast().getScore());
        Assertions.assertEquals(expectedList.getLast().getPlayerName(), result.getLast().getPlayerName());
    }
}
