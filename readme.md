# Precondition

- Connect to 45.132.17.22 VM via user **gevorg**
- cd ./selenoid/playbook
- in terminal run: ansible-playbook -i hosts tasks.yml --ask-become-pass

---

## Running Tests

Run the full test suite from the terminal with:

```bash
mvn clean test -DthreadCount=3