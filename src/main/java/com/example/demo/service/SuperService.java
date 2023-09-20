package com.example.demo.service;

import com.example.demo.entity.TechLead;

import java.util.List;

public interface SuperService<REQ,RESP,ID> {
    RESP create(REQ reqDto);
    RESP modify(ID id, REQ dto);
    RESP showOne(ID id);
    RESP remove(ID id);
    List<RESP> showAll();
}
