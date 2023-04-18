package com.homs.hardware_order_management_system.controller;

import com.homs.hardware_order_management_system.dto.HardwareSearchRequestDTO;
import com.homs.hardware_order_management_system.model.dto.HardwareDTO;
import com.homs.hardware_order_management_system.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/hardware")
public class HardwareController {

    @Autowired
    private HardwareService hardwareService;



    //get all hardwareID
    @GetMapping(value = "/get-all-hardware")
    public ResponseEntity<List<HardwareDTO>> getAllHardware(){
        List<HardwareDTO> hardwareList = this.hardwareService.getAllHardware();
        return new ResponseEntity<>(hardwareList,HttpStatus.OK);
    }

    //get all active hardware
    @GetMapping(value = "get-all-active-hardware")
    public ResponseEntity<List<HardwareDTO>> getAllActiveHardware(){
        List<HardwareDTO> result = this.hardwareService.getAllActiveHardware();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    //search hardwareID by id
    @GetMapping(value = "/search-hardware/{hardwareID}")
    public ResponseEntity<HardwareDTO> searchHardware(@PathVariable Integer hardwareID){
        HardwareDTO hardwareDTO = this.hardwareService.searchHardware(hardwareID);
        return new ResponseEntity<>(hardwareDTO,HttpStatus.OK);
    }

    //get by hardware name
    @PostMapping(value = "/get-hardwares-by-name/{hardwareName}")
    public ResponseEntity<List<HardwareDTO>> getHardwaresByName(@PathVariable String hardwareName){
        List<HardwareDTO> hardwareDTOList = this.hardwareService.getHardwaresByName(hardwareName);
        return new ResponseEntity<>(hardwareDTOList,HttpStatus.OK);
    }

    //get by hardware address

    //get by hardware tel

    //save hardwareID
//    @PostMapping(value = "/save-hardware")
//    public ResponseEntity<HardwareDTO> saveHardware(@RequestBody HardwareDTO hardwareDTO){
//        HardwareDTO newHardware = this.hardwareService.saveHardware(hardwareDTO);
//        return new ResponseEntity<>(newHardware,HttpStatus.CREATED);
//    }

    //update hardwareID
//    @PutMapping(value = "/update-hardwareID")


    //save and update hardwareID
    @PostMapping(value = "/save-and-update-hardware")
    public ResponseEntity<HardwareDTO> saveAndUpdateHardware(@RequestBody HardwareDTO hardwareDTO){
        HardwareDTO newHardware = this.hardwareService.saveAndUpdateHardware(hardwareDTO);
        return  new ResponseEntity<>(newHardware,HttpStatus.CREATED);
    }


    //delete hardwareID
    @DeleteMapping(value = "/delete-hardware/{hardwareID}")
    public ResponseEntity<Boolean> deleteHardware(@PathVariable Integer hardwareID){
            Boolean result = this.hardwareService.deleteHardware(hardwareID);
            return new ResponseEntity<>(result,HttpStatus.OK);
    }



    //get all hardwares jdbc
    @RequestMapping(value = "/get-all-hardware-jdbc", method = RequestMethod.POST)
    public  ResponseEntity<List<HardwareDTO>> getAllHardwaresWithSearch(@RequestBody HardwareSearchRequestDTO hardwareSearchRequestDTO){
        List<HardwareDTO> hardwares = this.hardwareService.getAllHardwaresJdbc(hardwareSearchRequestDTO);
        return new ResponseEntity<>(hardwares,HttpStatus.OK);
    }


}
