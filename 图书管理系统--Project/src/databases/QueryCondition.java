package databases;
/*
查询条件的接口
 */
public interface QueryCondition<E> {
    boolean condition(E e);
}
