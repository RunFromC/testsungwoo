package com.project.demo.service;

import com.project.demo.repository.mapper.dohwan.DohwanMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {

    private final DohwanMapper dohwanMapper;

    public List<Map<String, Object>> getUserList() {
        return dohwanMapper.getUserList();
    }
}
