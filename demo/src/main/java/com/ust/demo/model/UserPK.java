package com.ust.demo.model;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.*;

@NoArgsConstructor
@Data
@Embeddable
@AllArgsConstructor
public class UserPK implements Serializable{
    private int userId;
    private String userType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPK userPK)) return false;
        return userId == userPK.userId && Objects.equals(userType, userPK.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userType);
    }

}
