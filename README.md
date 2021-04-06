# My Personal Project: ToStart

## What is ToStart

**ToStart** is a to-do list application. 
Its goal is to help users keeping track of things to do in their different aspects of life.
By creating to-do lists using **ToStart**, users can organize their daily life easily without missing any important dates and tasks.

## Target Users

- _Students_ who are busy with course works and after school activities
- _Employees_ who want to balance job and life


## Why ToStart

As a university student,  to-do list is one of the most important elements in my life. This help me a lot on my schoolwork, from different deadlines to exam schedule, I always put things on the todo list application in my phone.
So when this course offers me a chance to create my own application, I definitely would choose to design a to-do list application.

## User Stories

As a user, I want to be able to add a task to my to-do list

As a user, I want to be able to view the list of tasks on my to-do list

As a user, I want to be able to delete a task from my to-do-list

As a user, I want to be able to save my to-do list to file.

As a user, I want to be able to load my to-do list.

##Phase 4: Task 2

Option 1：In Task class, I make the constructor of task to have a robust design by adding two methods checkTask and checkState to 
make sure the user input for a task has no punctuations, and the state is no longer than 30 characters. 
Otherwise, exceptions will be thrown.

##Phase 4: Task 3

- In ToDoList class, I would add a "SearchTask" method that can be used by both updateTaskState method and deleteTask method
to avoid duplication.

- I would create two new classes for the two inner classes in the MainApp class which can make the ui more clear.
