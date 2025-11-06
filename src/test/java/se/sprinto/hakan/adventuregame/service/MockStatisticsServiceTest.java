package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockStatisticsServiceTest {
    // Annotation makes a mocked object of the class without instancing it (automatically)
    @Mock
    private StatisticsDao mockDao;

    // Injects mock objects into this instance
    @InjectMocks
    private StatisticsService service;

    // Hardcoded unsorted list
    List<Statistics> unsortedList = new ArrayList<>(List.of(
            new Statistics("Anwar", 108),
            new Statistics("Martin", 210),
            new Statistics("Paveena", 150)
    ));


    @Test
    public void testGetSortedStatisticsWithMock() {
        // when loadAll() calls return unsortedList
        when(mockDao.loadAll()).thenReturn(unsortedList);

        List<Statistics> result = service.getSortedStatistics();

        // Verify sorted
        Assertions.assertEquals(210, result.get(0).getScore());
        Assertions.assertEquals(150, result.get(1).getScore());
        Assertions.assertEquals(108, result.get(2).getScore());

        verify(mockDao).loadAll();
    }
}
