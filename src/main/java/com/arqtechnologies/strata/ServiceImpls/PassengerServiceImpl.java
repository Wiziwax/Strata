package com.arqtechnologies.strata.ServiceImpls;

import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.Routes;
import com.arqtechnologies.strata.DTOs.UserDTOs.DriverResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerResponseDTO;
import com.arqtechnologies.strata.Entities.Driver;
import com.arqtechnologies.strata.Entities.Passenger;
import com.arqtechnologies.strata.Entities.Ride;
import com.arqtechnologies.strata.Repositories.DriverRepository;
import com.arqtechnologies.strata.Repositories.PassengerRepository;
import com.arqtechnologies.strata.Repositories.RideRepository;
import com.arqtechnologies.strata.Services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.arqtechnologies.strata.Enums.EnumRole.PASSENGER;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    RideRepository rideRepository;
    @Autowired
    DriverRepository driverRepository;

    @Override
    public String createPassenger(PassengerRequestDTO passengerRequestDTO) {

        Passenger newPassenger = new Passenger();

        newPassenger.setFirstName(passengerRequestDTO.getFirstName());
        newPassenger.setLastName(passengerRequestDTO.getLastName());
        newPassenger.setEmail(passengerRequestDTO.getEmail());
        newPassenger.setPassword(passengerRequestDTO.getPassword());
        newPassenger.setPhoneNumber(passengerRequestDTO.getPhoneNumber());
        newPassenger.setPhoneNumber2(passengerRequestDTO.getPhoneNumber2());
        newPassenger.setCreatedDate(new Date());
//        newPassenger.setCreatedBy();//TODO AUTHENTICATION
        newPassenger.setUserRole(PASSENGER);

        passengerRepository.save(newPassenger);

        return "Successfully Created";
    }

    @Override
    public PassengerResponseDTO updatePassenger(PassengerRequestDTO passengerRequestDTO) {

        Passenger passenger = passengerRepository.findById(passengerRequestDTO.getPassengerId())
                .orElseThrow(()-> new RuntimeException("Couldn't find passenger with ID " +
                        passengerRequestDTO.getPassengerId()));

        passenger.setFirstName(passengerRequestDTO.getFirstName());
        passenger.setLastName(passengerRequestDTO.getLastName());
        passenger.setPhoneNumber(passengerRequestDTO.getPhoneNumber());
        passenger.setPhoneNumber2(passengerRequestDTO.getPhoneNumber2());

        passengerRepository.save(passenger);

        return null;
    }

    @Override
    public List<DriverResponseDTO> getDriversInPath(Integer passengerId, RideRequestDTO rideRequestDTO) {

        List<Ride> availableRides = rideRepository.getAllByTravelPathAndCreatorRole(rideRequestDTO.getRoute(), 0);

        List<Integer> driverIds = new ArrayList<>();

        if (availableRides != null){
            for (Ride ride : availableRides) {
                driverIds.add(ride.getDriverId());
            }
        }

        List<Driver> driversInPath =driverRepository.findAllById(driverIds);
        //TODO LET IT NOT JUST CONTAIN EVERYONE HEADING THERE, OTHERWISE EVEN PEOPLE NOT IN PATH WILL BE IDENTIFIED,
        // SO ALSO FILTER BY PATH AND DESTINATION

        //TODO USE GOOGLE API TO FIND THE PATHS AND GET THE DRIVERS ACTUALLY HEADING IN THE SAME PATH.
        return driversInPath.stream().map(driver -> DriverResponseDTO.builder()

                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .phoneNumber(driver.getPhoneNumber())
                .phoneNumber2(driver.getPhoneNumber2())
                .isAvailable(driver.getIsAvailable())
                .carModel(driver.getCarModel())
                .carColour(driver.getCarColour())
                .carCapacity(driver.getCarCapacity())
                .carPlateNumber(driver.getCarPlateNumber())
                .averageRating(driver.getAverageRating())
                .carType(driver.getCarType())
                .trips(driver.getTrips()).build()).toList();
    }

//    public Routes getDestinationRoutes(String Destination){
//
//    }
}
