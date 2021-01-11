package com.vms.QrCode;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface QrcodeRepository extends MongoRepository<QrCode,String> {

@Query("{'mobile_no':?0}")
List<QrCode> getQrCode(String phone_no);
}
