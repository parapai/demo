package com.example.demo.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TblKaryawan;
import com.example.demo.request.AddKaryawanRequest;
import com.example.demo.request.UpdateKaryawanRequest;
import com.example.demo.service.KaryawanService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "api")
public class KaryawanController {
	
	@Autowired
	KaryawanService karyawanService;
	

	@GetMapping("/allKaryawan")
	public ResponseEntity <List<TblKaryawan>> searchKaryawan(){
		
		List<TblKaryawan> listData = karyawanService.searchKaryawan();


		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(listData);
	}
	
	@PostMapping("/addKaryawan")
	public ResponseEntity <TblKaryawan> addKaryawan(@RequestBody AddKaryawanRequest addReq){
		
		TblKaryawan insertData = karyawanService.addKaryawan(addReq);


		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(insertData);
	}
	
	@PostMapping("/updateKaryawan/{nik}")
	public ResponseEntity <TblKaryawan> addKaryawan(@RequestBody UpdateKaryawanRequest updateReq, @PathVariable String nik){
		
		TblKaryawan insertData = karyawanService.updateKaryawan(updateReq, nik);


		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(insertData);
	}
	
	@GetMapping("/deleteKaryawan/{nik}")
	public ResponseEntity <TblKaryawan> deleteKaryawan(@PathVariable String nik){
		
		if(StringUtils.isEmpty(nik)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(null);
		}
		
		TblKaryawan deleteData = karyawanService.deleteKaryawan(nik);


		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(deleteData);
	}
}
