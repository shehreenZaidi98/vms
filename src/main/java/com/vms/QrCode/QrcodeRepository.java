package com.vms.QrCode;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrcodeRepository extends MongoRepository<QrCode,String> {


}
