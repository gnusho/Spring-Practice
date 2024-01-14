package com.gnusho.practice.service;

import com.gnusho.practice.api.dto.ReqPostA;
import com.gnusho.practice.api.dto.ResGetA;
import com.gnusho.practice.api.dto.ResGetAList;
import com.gnusho.practice.domain.A;
import com.gnusho.practice.repository.TestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    @Transactional
    public void createA(ReqPostA reqPostA) throws Exception {

        if(testRepository.existsById(reqPostA.getPkA())) {
            throw new SQLIntegrityConstraintViolationException();
        }

        A a = A.builder()
                .pkA(reqPostA.getPkA())
                .stringA(reqPostA.getStringA())
                .dateA(reqPostA.getDateA())
                .build();

        testRepository.save(a);
    }

    public ResGetA getA(Long pkA) {
        ResGetA.ResGetABuilder resGetABuilder = ResGetA.builder();
        A a = testRepository.findById(pkA)
                .orElseThrow(() -> new NullPointerException("A를 찾을 수 없음"));

        return resGetABuilder
                .pkA(a.getPkA())
                .stringA(a.getStringA())
                .dateA(a.getDateA())
                .build();
    }

    public ResGetAList getAList() {
        List<A> AList = testRepository.findAll();
        ResGetAList resGetAList = new ResGetAList();
        for(A a : AList) {
            resGetAList.getAList().add(
                    ResGetA.builder()
                            .pkA(a.getPkA())
                            .stringA(a.getStringA())
                            .dateA(a.getDateA())
                            .build()
            );
        }

        return resGetAList;
    }

    @Transactional
    public void modifyA(Long pkA, ReqPostA reqPutA) {
        A a = testRepository.findById(pkA)
                .orElseThrow(() -> new NullPointerException("A를 찾을 수 없음"));

        a.updateA(reqPutA.getStringA(), reqPutA.getDateA());
    }

    @Transactional
    public void deleteA(Long pkA) {
        A a = testRepository.findById(pkA)
                .orElseThrow(() -> new NullPointerException("A를 찾을 수 없음"));

        testRepository.delete(a);
    }
}
