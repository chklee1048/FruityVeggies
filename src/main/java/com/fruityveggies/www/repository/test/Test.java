package com.fruityveggies.www.repository.test;

import com.fruityveggies.www.dto.TestUpdateDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity // JPA 엔터티 클래스 - 데이터베이스 테이블과 매핑되는 클래스.
@Table(name = "TEST") // 엔터티 클래스 이름이 데이터베이스 테이블 이름과 다른 경우, 테이블 이름을 명시.
@SequenceGenerator(name = "TEST_SEQ_GEN", sequenceName = "TEST_SEQ", allocationSize = 1)
public class Test {
    @Id // Primary key 제약조건
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SEQ_GEN")
    private Long id;
    
    @Column(nullable = false) // Not Null 제약조건
    private String data;
    
    public Test update(TestUpdateDto dto) {
        this.data = dto.getData();
        
        return this;
    }
}
