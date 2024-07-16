//package com.microservice.metadata.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//
//import com.microservice.metadata.dao.CityRepository;
//import com.microservice.metadata.dao.CountryRepository;
//import com.microservice.metadata.dao.StateRepository;
//import com.microservice.metadata.entity.City;
//import com.microservice.metadata.entity.Country;
//import com.microservice.metadata.entity.State;
//import com.microservice.metadata.exception.MetadataException;
//import com.microservice.metadata.response.CityDto;
//import com.microservice.metadata.response.StateDto;
//import com.microservice.metadata.service.impl.AddressServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//public class AddressServiceImplTest {
//
//    @Mock
//    private CountryRepository countryRepository;
//
//    @Mock
//    private StateRepository stateRepository;
//
//    @Mock
//    private CityRepository cityRepository;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    @InjectMocks
//    private AddressServiceImpl addressServiceImpl;
//
//    private Country country;
//    private State state;
//    private City city;
//    private StateDto stateDto;
//    private CityDto cityDto;
//
//    @BeforeEach
//    void setUp() {
//        country = new Country();
//        country.setId(1L);
//        country.setName("Country");
//
//        state = new State();
//        state.setId(1L);
//        state.setName("State");
//        state.setId(1L);
//
//        city = new City();
//        city.setId(1L);
//        city.setName("City");
//        city.setId(1L);
//
//        stateDto = new StateDto();
//        stateDto.setId(1L);
//        stateDto.setName("State");
//
//        cityDto = new CityDto();
//        cityDto.setId(1L);
//        cityDto.setName("City");
//    }
//
//    @Test
//    void testGetAllCountries() {
//        when(countryRepository.findAll()).thenReturn(Arrays.asList(country));
//
//        List<Country> countries = addressServiceImpl.getAllCountries();
//
//        assertEquals(1, countries.size());
//        assertEquals("Country", countries.get(0).getName());
//        verify(countryRepository).findAll();
//    }
//
//    @Test
//    void testGetStatesByCountryId_Success() throws MetadataException {
//        when(countryRepository.findById(1L)).thenReturn(Optional.of(country));
//        when(stateRepository.findByCountryId(1L)).thenReturn(Arrays.asList(state));
//        when(modelMapper.map(state, StateDto.class)).thenReturn(stateDto);
//
//        List<StateDto> states = addressServiceImpl.getStatesByCountryId(1L);
//
//        assertEquals(1, states.size());
//        assertEquals("State", states.get(0).getName());
//        verify(countryRepository).findById(1L);
//        verify(stateRepository).findByCountryId(1L);
//    }
//
//    @Test
//    void testGetStatesByCountryId_CountryNotFound() {
//        when(countryRepository.findById(1L)).thenReturn(Optional.empty());
//
//        MetadataException exception = assertThrows(MetadataException.class, () -> {
//            addressServiceImpl.getStatesByCountryId(1L);
//        });
//
//        assertEquals("Country not found", exception.getMessage());
//        verify(countryRepository).findById(1L);
//    }
//
//    @Test
//    void testGetCityByStateId_Success() throws MetadataException {
//        when(stateRepository.findById(1L)).thenReturn(Optional.of(state));
//        when(cityRepository.findByStateId(1L)).thenReturn(Arrays.asList(city));
//        when(modelMapper.map(city, CityDto.class)).thenReturn(cityDto);
//
//        List<CityDto> cities = addressServiceImpl.getCityByStateId(1L);
//
//        assertEquals(1, cities.size());
//        assertEquals("City", cities.get(0).getName());
//        verify(stateRepository).findById(1L);
//        verify(cityRepository).findByStateId(1L);
//    }
//
//    @Test
//    void testGetCityByStateId_StateNotFound() {
//        when(stateRepository.findById(1L)).thenReturn(Optional.empty());
//
//        MetadataException exception = assertThrows(MetadataException.class, () -> {
//            addressServiceImpl.getCityByStateId(1L);
//        });
//
//        assertEquals("State not found", exception.getMessage());
//        verify(stateRepository).findById(1L);
//    }
//}
