package za.ac.cput.repository.impl.TouristDetails;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.TouristDetails.TouristType;
import za.ac.cput.repository.TouristDetails.TouristTypeRepository;

import java.util.Set;

import static org.junit.Assert.*;

public class TouristTypeRepositoryImplTest {

    private TouristTypeRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = TouristTypeRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getRepository() {
    }

    @Test
    public void create() {

        this.repository.create(null);
        Assert.assertEquals(null, null);
    }

    @Test
    public void read() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
        Set<TouristType> tourist = this.repository.getAll();
        Assert.assertEquals(1, tourist.size());
    }
}