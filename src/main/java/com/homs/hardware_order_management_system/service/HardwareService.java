package com.homs.hardware_order_management_system.service;

import com.homs.hardware_order_management_system.dao.HardwareDAO;
import com.homs.hardware_order_management_system.dao.jdbc.HardwareJDBCDAO;
import com.homs.hardware_order_management_system.dto.HardwareSearchRequestDTO;
import com.homs.hardware_order_management_system.model.Hardware;
import com.homs.hardware_order_management_system.model.dto.HardwareDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HardwareService {

    @Autowired
    private HardwareDAO hardwareDAO;

    @Autowired
    private HardwareJDBCDAO hardwareJDBCDAO;


    //get all hardwareID
    public List<HardwareDTO> getAllHardware(){
        List<Hardware> hardwareList = hardwareDAO.findAll();

        List<HardwareDTO> hardwareDTOList = new ArrayList<>();
        for (Hardware hardware:hardwareList){
            HardwareDTO hardwareDTO = new HardwareDTO(hardware);

            hardwareDTOList.add(hardwareDTO);
        }
        return hardwareDTOList;
    }

    //search hardwareID by id
    public HardwareDTO searchHardware(Integer hardwareID){
        Hardware hardware = this.hardwareDAO.getHardwareByHardwareID(hardwareID);
        return  new HardwareDTO(hardware);
    }


    //get hardwareID by name
    public List<HardwareDTO> getHardwaresByName(String hardwareName){

        List<Hardware> hardwareList = hardwareDAO.findAllByHardwareName(hardwareName);

        List<HardwareDTO> hardwareDTOList = new ArrayList<>();
        for (Hardware hardware:hardwareList){
            HardwareDTO hardwareDTO = new HardwareDTO(hardware);

            hardwareDTOList.add(hardwareDTO);
        }
        return hardwareDTOList;
    }


    //save hardwareID
//    public HardwareDTO saveHardware(HardwareDTO hardwareDTO){
//        Hardware hardware = new Hardware();
//        hardware.setHardwareName(hardwareDTO.getHardwareName());
//        hardware.setHardwareAddress(hardwareDTO.getHardwareAddress());
//        hardware.setHardwareTel(hardwareDTO.getHardwareTel());
//        hardware.setHardwareEmail(hardwareDTO.getHardwareEmail());
//        hardware.setHardwareStatus(hardwareDTO.getHardwareStatus());
//
//        this.hardwareDAO.saveAndFlush(hardware);
//        return new HardwareDTO(hardware);
//    }

    //update hardwareID


    //save and update hardwareID
    public HardwareDTO saveAndUpdateHardware(HardwareDTO hardwareDTO){
        Hardware existingHardware = null;

        if (hardwareDTO.getHardwareID()!=null){
            existingHardware = hardwareDAO.getReferenceById(hardwareDTO.getHardwareID());
        }else {
            existingHardware = new Hardware();
        }

        existingHardware.setHardwareName(hardwareDTO.getHardwareName());
        existingHardware.setHardwareAddress(hardwareDTO.getHardwareAddress());
        existingHardware.setHardwareTel(hardwareDTO.getHardwareTel());
        existingHardware.setHardwareEmail(hardwareDTO.getHardwareEmail());
        existingHardware.setHardwareStatus(hardwareDTO.getHardwareStatus());

        this.hardwareDAO.saveAndFlush(existingHardware);
        return new HardwareDTO(existingHardware);

    }



    //get all hardware jdbc
    public  List<HardwareDTO> getAllHardwaresJdbc(HardwareSearchRequestDTO hardwareRQ){
        List<HardwareDTO> hardwareDTOList = this.hardwareJDBCDAO.getAllHardwaresJdbc(hardwareRQ);
        return hardwareDTOList;
    }

    //delete hardware
    public Boolean deleteHardware(Integer hardwareID) {
        Hardware existingHardware = this.hardwareDAO.getHardwareByHardwareID(hardwareID);
        if (existingHardware!=null){
            hardwareDAO.deleteById(hardwareID);
            return true;
        }else {
            return false;
        }

    }

    //get all active hardware
    public List<HardwareDTO> getAllActiveHardware() {
        List<HardwareDTO> activeHardwareList = this.hardwareJDBCDAO.getAllActiveHardware();
        return activeHardwareList;
    }
}
