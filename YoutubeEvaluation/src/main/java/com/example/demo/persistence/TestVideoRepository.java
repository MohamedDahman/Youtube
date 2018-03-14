package com.example.demo.persistence;

import com.example.demo.persistence.TestVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestVideoRepository extends JpaRepository<TestVideo,Long> {
}
