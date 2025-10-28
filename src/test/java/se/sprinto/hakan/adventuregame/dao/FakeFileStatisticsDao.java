package se.sprinto.hakan.adventuregame.dao;

import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class FakeFileStatisticsDao implements StatisticsDao {
    public void testGetSortedStatistics() {

    }

    @Override
    public void save(Statistics stat) {}

    @Override
    public List<Statistics> loadAll() {
        List<Statistics> list = new ArrayList<>();
        list.add(new Statistics("Anwar", 108));
        list.add(new Statistics("Martin", 210));
        list.add(new Statistics("Paveena", 150));
        return list;
    }
}
