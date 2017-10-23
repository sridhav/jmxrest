package com.github.sridhav.jmxrest.api.dto;

import java.util.ArrayList;
import java.util.List;

public class DomainListDto {

    List<DomainDto> domainDtos;

    public List<DomainDto> getDomainDtos() {
        return domainDtos;
    }

    public void setDomainDtos(List<DomainDto> domainDtos) {
        this.domainDtos = domainDtos;
    }


    public static DomainListDto convertToDomainListDto (List<String> domains, String namespace){
        DomainListDto domainListDto = new DomainListDto();
        List<DomainDto> domainDtos = new ArrayList<>();
        for (String domain: domains) {
            DomainDto domainDto = DomainDto.convertTo(domain, namespace);
        }
        domainListDto.setDomainDtos(domainDtos);

        return domainListDto;
    }

}
