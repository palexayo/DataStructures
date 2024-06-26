package List;

public interface IList<T> {
    public void insert(T object, int position);
    void delete(int position);
    T access(int position);
    //search
    IList<T> append(IList<T> listOne, IList<T> listTwo);

}
