package com.example.demo.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TblKaryawan;
import com.example.demo.repository.KaryawanRepository;
import com.example.demo.request.AddKaryawanRequest;
import com.example.demo.request.UpdateKaryawanRequest;

@Service
public class KaryawanService {

	@Autowired
	KaryawanRepository karyawanRepository;

	public List<TblKaryawan> searchKaryawan() {

		return karyawanRepository.findAll();

	}

	public TblKaryawan addKaryawan(AddKaryawanRequest addReq) {
		TblKaryawan ent = new TblKaryawan();
		if (addReq != null) {
			int min = 0;
			int max = 9999;
			int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
			String getDob = formatter.format(addReq.getDob());
			String nikString = String.valueOf(random_int) + getDob;
			ent.setNik(nikString);
			ent.setNamaKrw(addReq.getNamaKrw());
			ent.setDob(addReq.getDob());
			ent.setEmail(addReq.getEmail());
			ent.setNoHp(addReq.getNoHp());
			ent.setAlamatKrw(addReq.getAlamatKrw());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			ent.setCreatedDate(timestamp);
			ent.setCreatedBy("SYSTEM");
			karyawanRepository.save(ent);
		}

		return ent;

	}

	public TblKaryawan updateKaryawan(UpdateKaryawanRequest updateReq, String nik) {
		TblKaryawan ent = karyawanRepository.findById(nik).orElse(null);

		if (ent != null) {
			if (updateReq != null) {

				if (!StringUtils.isEmpty(updateReq.getNamaKrw())) {
					ent.setNamaKrw(updateReq.getNamaKrw());
				}
				if (updateReq.getDob() != null) {
					ent.setDob(updateReq.getDob());
				}
				if (!StringUtils.isEmpty(updateReq.getEmail())) {
					ent.setEmail(updateReq.getEmail());
				}
				if (!StringUtils.isEmpty(updateReq.getNoHp())) {
					ent.setNoHp(updateReq.getNoHp());
				}
				if (!StringUtils.isEmpty(updateReq.getAlamatKrw())) {
					ent.setAlamatKrw(updateReq.getAlamatKrw());
				}
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				ent.setUpdatedBy("SYSTEM");
				ent.setUpdatedDate(timestamp);
				karyawanRepository.save(ent);
			}
		}

		return ent;

	}

	public TblKaryawan deleteKaryawan(String nik) {

		TblKaryawan ent = karyawanRepository.findById(nik).orElse(null);
		karyawanRepository.delete(ent);
		return ent;
	}
}
