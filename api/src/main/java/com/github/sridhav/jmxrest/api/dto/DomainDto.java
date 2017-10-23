package com.github.sridhav.jmxrest.api.dto;

public class DomainDto {
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    private String domain;
    private String namespace;

    public static DomainDto convertTo(String domain, String namespace) {
        DomainDto domainDto = new DomainDto();
        domainDto.setDomain(domain);
        domainDto.setNamespace(namespace);

        return domainDto;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

}
