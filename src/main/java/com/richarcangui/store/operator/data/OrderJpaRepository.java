package com.richarcangui.store.operator.data;

import com.richarcangui.store.operator.model.db.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
