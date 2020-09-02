package springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springdemo.entity.Employee;

import java.util.List;

@Repository //always apply for DAO implementations
public class EmployeeDAOImpl implements EmployeeDAO {

    //need to inject the session factory
    //in /servlet.xml step 2 is bean configuration
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getEmployees() {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create query .. sort by last name (can be different)
        Query<Employee> theQuery = currentSession.createQuery("from Employee order by lastName",
                                                                  Employee.class);

        //get list, execute query
        List<Employee> employees = theQuery.getResultList();

        return employees;


    }

    @Override
    public void saveEmployee(Employee theEmployee) {

        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/update the customer, checks if it exists in db
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public Employee getEmployee(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Employee theEmployee = currentSession.get(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public void deleteEmployee(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Employee theEmployee = currentSession.get(Employee.class, theId);

        currentSession.delete(theEmployee);
    }
}
