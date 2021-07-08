package com.banger.backend.Controller;

import com.banger.backend.DTO.equipmentDTO;
import com.banger.backend.DTO.userDTO;
import com.banger.backend.DTO.vehicleDTO;
import com.banger.backend.Entity.*;
import com.banger.backend.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/admin")
public class adminController {

    @Autowired
    private userService userService;

    @Autowired
    private vehicleService vehicleService;

    @Autowired
    private equipmentService equipService;

    @Autowired
    private bookingService bookingService;

    @Autowired
    private inquiryService inqService;



    @PostMapping("/addVehicle")
    public ResponseEntity<vehicleDTO> addVehicle(@RequestBody vehicleDTO dto){
        Vehicle addedVehicle= this.vehicleService.addVehicle(dto);
        return new ResponseEntity(addedVehicle, CREATED);
    }

    @PostMapping("/addEquipment")
    public ResponseEntity<equipmentDTO> addEquipments(@RequestBody equipmentDTO dto){
       Equipment addedEquip= this.equipService.addEquipments(dto);
        return new ResponseEntity(addedEquip, CREATED);
    }

    @GetMapping("/viewInquiries")
    public List<Inquiry> viewAllInquiries(){
        return inqService.getAllInquiries();
    }

    @GetMapping("/getSingleInquiry/{inquiryId}")
    public Inquiry getInquirtById(@PathVariable(value = "inquiryId") Integer inquiryId ){
        return inqService.getInquiryById(inquiryId);
    }

    @GetMapping("/viewAllVehicles")
    public List<Vehicle> viewAllVehicles(){
        return vehicleService.getAllVehicles();
    }


    @GetMapping("/viewPendingUsers")
    public List<userDTO> viewPendingUsers(){
        return userService.getAllPendingUsersToList();
    }

    @GetMapping("/viewAllUsers")
    public List<userDTO> viewAllUsers(){
        return userService.getAllUsersToList();
    }

    @GetMapping("/viewEquipments")
    public List<Equipment>viewAllEquipments(){
        return equipService.getAllEquipments();
    }

    @GetMapping("/viewAllBookings")
    public List<Booking> viewAllBookings(){
        return bookingService.getAllBookingsToList();
    }

}
