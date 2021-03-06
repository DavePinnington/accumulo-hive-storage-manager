package org.apache.accumulo.storagehandler.predicate.compare;

import java.math.BigDecimal;
import java.nio.ByteBuffer;

/**
 *
 * Set of comparison operations over a double constant. Used for Hive
 * predicates involving double comparison.
 *
 * Used by {@link org.apache.accumulo.storagehandler.predicate.PrimitiveComparisonFilter}
 *
 */
public class DoubleCompare implements PrimitiveCompare {

    private BigDecimal constant;

    /**
     *
     */
    public void init(byte[] constant) {
        this.constant = serialize(constant);
    }

    /**
     *
     * @return BigDecimal holding double byte [] value
     */
    public BigDecimal serialize(byte[] value) {
        try {
            return new BigDecimal(ByteBuffer.wrap(value).asDoubleBuffer().get());
        } catch (Exception e) {
            throw new RuntimeException(e.toString() + " occurred trying to build double value. " +
                    "Make sure the value type for the byte[] is double ");
        }
    }

    /**
     *
     * @return true if double value is equal to constant, false otherwise.
     */
    @Override
    public boolean isEqual(byte[] value) {
        return serialize(value).compareTo(constant) == 0;
    }

    /**
     *
     * @return true if double value not equal to constant, false otherwise.
     */
    @Override
    public boolean isNotEqual(byte[] value) {
        return serialize(value).compareTo(constant) != 0;
    }

    /**
     *
     * @return true if value greater than or equal to constant, false otherwise.
     */
    @Override
    public boolean greaterThanOrEqual(byte[] value) {
        return serialize(value).compareTo(constant) >= 0;
    }

    /**
     *
     *
     * @return true if value greater than constant, false otherwise.
     */
    @Override
    public boolean greaterThan(byte[] value) {
        return serialize(value).compareTo(constant) > 0;
    }

    /**
     *
     *
     * @return true if value less than or equal than constant, false otherwise.
     */
    @Override
    public boolean lessThanOrEqual(byte[] value) {
        return serialize(value).compareTo(constant) <= 0;
    }

    /**
     *
     *
     * @return true if value less than constant, false otherwise.
     */
    @Override
    public boolean lessThan(byte[] value) {
        return serialize(value).compareTo(constant) < 0;
    }

    /**
     * not supported for this PrimitiveCompare implementation.
     */
    @Override
    public boolean like(byte[] value) {
        throw new UnsupportedOperationException("Like not supported for " + getClass().getName());
    }
}
