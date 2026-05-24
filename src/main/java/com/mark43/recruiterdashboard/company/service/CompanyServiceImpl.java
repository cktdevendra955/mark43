package com.mark43.recruiterdashboard.company.service;

import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.recruiterdashboard.company.dto.CompanyDto;
import com.mark43.recruiterdashboard.company.entity.CompanyEntity;
import com.mark43.recruiterdashboard.company.repository.CompanyRepository;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Override
    public ResponseEntity<?> create(CompanyDto dto) {
        CompanyEntity company = new CompanyEntity();
        company.setName(dto.getName());
        company.setLogo(dto.getLogo());
        company.setWebsite(dto.getWebsite());
        company.setIndustry(dto.getIndustry());
        company.setAbout(dto.getAbout());
        company.setCompanySize(dto.getCompanySize());
        company.setFoundedYear(dto.getFoundedYear());
        company.setEmail(dto.getEmail());
        company.setPhone(dto.getPhone());
        company.setCountry(dto.getCountry());
        company.setState(dto.getState());
        company.setCity(dto.getCity());
        company.setPincode(dto.getPincode());
        company.setAddress(dto.getAddress());
        company.setVerified(dto.getVerified());
        company.setActive(dto.getActive());
        this.companyRepository.save(company);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,null);
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, CompanyDto dto) {
        CompanyEntity company = this.companyRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        company.setName(dto.getName());
        company.setLogo(dto.getLogo());
        company.setWebsite(dto.getWebsite());
        company.setIndustry(dto.getIndustry());
        company.setAbout(dto.getAbout());
        company.setCompanySize(dto.getCompanySize());
        company.setFoundedYear(dto.getFoundedYear());
        company.setEmail(dto.getEmail());
        company.setPhone(dto.getPhone());
        company.setCountry(dto.getCountry());
        company.setState(dto.getState());
        company.setCity(dto.getCity());
        company.setPincode(dto.getPincode());
        company.setAddress(dto.getAddress());
        company.setVerified(dto.getVerified());
        company.setActive(dto.getActive());
        this.companyRepository.save(company);
        return ResponseUtils.created(ResponseUtils.UPDATED_SUCCESSFULLY,null);
    }

    @Override
    public ResponseEntity<?> getAll(Map<String, Object> params) {
        return ResponseUtils.created(ResponseUtils.SUCCESS,null);
    }

    @Override
    public ResponseEntity<?> getByUniqueId(UUID uniqueId) {
        return ResponseUtils.created(ResponseUtils.DATA_FOUND,null);
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {

        
        return ResponseUtils.created(ResponseUtils.DELETED_SUCCESSFULLY,null);
    }
}
