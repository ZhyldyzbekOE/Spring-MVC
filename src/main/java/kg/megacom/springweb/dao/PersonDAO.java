package kg.megacom.springweb.dao;

import kg.megacom.springweb.models.Person;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
//        people.add(new Person(++PEOPLE_COUNT, "Tom"));
//        people.add(new Person(++PEOPLE_COUNT, "Bob"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        System.out.println(person);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        System.out.println(personToBeUpdated);
        for (int i = 0; i < people.size(); i++){
            if (people.get(i).getId() == personToBeUpdated.getId()){
                personToBeUpdated.setName(updatedPerson.getName());
                personToBeUpdated.setEmail(updatedPerson.getEmail());
                personToBeUpdated.setPassword(updatedPerson.getPassword());
//                people.remove(i);
//                people.add(updatedPerson);
                break;
            }
        }
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}