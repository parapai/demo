package com.example.demo.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateKaryawanRequest {
	
	private String namaKrw;
	private String email;
	private Date dob;
	private String noHp;
	private String alamatKrw;

}
