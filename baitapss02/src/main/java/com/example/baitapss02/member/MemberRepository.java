package com.example.baitapss02.member;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepository {

    private final Map<Long, Member> members = new ConcurrentHashMap<>(
            Map.of(
                    1L, new Member(1L, "Nguyen Van An", "an@librax.vn")
            )
    );

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(members.get(id));
    }
}