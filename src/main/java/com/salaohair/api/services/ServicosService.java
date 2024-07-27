package com.salaohair.api.services;


import com.salaohair.api.dto.request.ServicosRequest;
import com.salaohair.api.dto.response.ServicosResponse;

import java.util.List;

public interface ServicosService {
    ServicosResponse findServicesById(Long servicesId);
    List<ServicosResponse> findAllServices();
    ServicosResponse createServices(ServicosRequest request);
    ServicosResponse updateServices(Long servicesId, ServicosRequest request);
    void deleteServices(Long servicesId);
}
