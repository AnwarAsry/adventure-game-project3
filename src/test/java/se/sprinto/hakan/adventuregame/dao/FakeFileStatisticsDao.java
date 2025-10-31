package se.sprinto.hakan.adventuregame.dao;

import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class FakeFileStatisticsDao implements StatisticsDao {
    @Override
    public void save(Statistics stat) {}

    @Override
    public List<Statistics> loadAll() {
        List<Statistics> list = new ArrayList<>(List.of(
            new Statistics("Anwar", 108),
            new Statistics("Martin", 210),
            new Statistics("Paveena", 150)
        ));
        return list;
    }
}
