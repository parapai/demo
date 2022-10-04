package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBL_KARYAWAN")
public class TblKaryawan extends BaseEntity{ 

	@Id
    @Column
    private String nik;

    @Column
    private String namaKrw;
    
    @Column
    private Date dob;
    
    @Column
    private String email;
    
    @Column
    private String noHp;
    
    @Column
    private String alamatKrw;
    
    
    
    
    
    
    
}
