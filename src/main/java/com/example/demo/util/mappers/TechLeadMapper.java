package com.example.demo.util.mappers;

import com.example.demo.dto.req.TechLeadReqDTO;
import com.example.demo.dto.res.TechLeadRespDTO;
import com.example.demo.entity.TechLead;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TechLeadMapper {
    TechLeadMapper INSTANCE = Mappers.getMapper(TechLeadMapper.class);

    //to entity (reqDto to entity)
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "mobile", target = "mobile")
    @Mapping(source = "email", target = "email")
    TechLead toEntity (TechLeadReqDTO dto);

    //to dto (entity to respDto)

    TechLeadRespDTO toTechLeadRespDTO(TechLead techLead);

    List<TechLeadRespDTO> toRespDtoList(List<TechLead> list);
}
