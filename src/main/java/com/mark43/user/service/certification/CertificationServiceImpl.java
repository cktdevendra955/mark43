package com.mark43.user.service.certification;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.user.dto.CertificationDto;
import com.mark43.user.entity.CertificationEntity;
import com.mark43.user.repo.CertificationRepository;
import com.mark43.utils.collectionutil.CollectionUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CertificationServiceImpl implements CertificationService{

    final CertificationRepository certificationRepository;

    @Override
    public ResponseEntity<?> create(CertificationDto dto) {
        try {
            CertificationEntity entity = new CertificationEntity();
            entity.setName(dto.getName());
            entity.setOrganization(dto.getOrganization());
            entity.setIssueDate(dto.getIssueDate());
            entity.setCertificateUrl(dto.getCertificateUrl());
            entity.setExpiryDate(dto.getExpiryDate());
            entity.setProfile(AuthUtil.getUserId());
            certificationRepository.save(entity);
            return ResponseUtils.created("created",null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, CertificationDto dto) {
        try {
            CertificationEntity entity = this.certificationRepository.findByUniqueId(uniqueId).orElseThrow(() -> new RuntimeException("NOT FOUND."));
            entity.setName(dto.getName());
            entity.setOrganization(dto.getOrganization());
            entity.setIssueDate(dto.getIssueDate());
            entity.setCertificateUrl(dto.getCertificateUrl());
            entity.setExpiryDate(dto.getExpiryDate());
            entity.setProfile(AuthUtil.getUserId());
            certificationRepository.save(entity);
            return ResponseUtils.created("created",null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<?> getAllByUser() {
        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> data_array = new LinkedList<>();
        List<CertificationEntity> certifications = certificationRepository.findByProfileId(AuthUtil.getUserId());
        if (CollectionUtil.isNotEmpty(certifications)){
            for (CertificationEntity data :certifications){
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("id",data.getUniqueId());
                dataMap.put("name",data.getName());
                dataMap.put("organization",data.getOrganization());
                dataMap.put("issueDate",data.getIssueDate());
                dataMap.put("expiryDate",data.getExpiryDate());
                dataMap.put("certificateUrl",data.getCertificateUrl());
                data_array.add(dataMap);
            }
        }
        response.put("data_array",data_array);
        return ResponseUtils.success("success",response);
    }


    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        try {
            CertificationEntity entity = this.certificationRepository.findByUniqueId(uniqueId).orElseThrow(() -> new RuntimeException("NOT FOUND."));
            certificationRepository.delete(entity);
            return ResponseUtils.success("Deleted.",null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
