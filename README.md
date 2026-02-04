# Kanban-Style Task Tracker
Building a Task tracker to improve backend knowledge and maybe find my own code writing style, will mostly add in a Japanese language button in the frontend.

## Features

- User authentication and role management
- Project and board organization
- Customizable workflows and statuses
- Task creation, assignment, and state tracking
- Task history for audit and progress tracking

## System Design

I haven't included the entire flow of the application yet - this only contains necessary information for me to get started in my backend.

### Low-Level System Design
#### Rough Entity Relationship Diagram

```
User
 └── Project
	 └── Board
		 └── Workflow
			 └── WorkflowStatus
		 └── Task
			 ├── TaskState
			 ├── TaskAssignment
			 └── TaskHistory
```

#### Entity Relationships

- A **User** can be assigned A **Role** (via UserRole).
- A **User** can participate in multiple **Projects** based on their **Role**.
- Each **Project** contains one or more **Boards**.
- Each **Board** has a **Workflow** defining its process.
- A **Workflow** consists of multiple **WorkflowStatuses**.
- **Tasks** are created on **Boards** and move through **WorkflowStatuses**.
- Each **Task** has a current **TaskState**, can be assigned to users (**TaskAssignment**), and maintains a **TaskHistory** for auditing.

### Security Components

| Component              | Responsibility                  |
|------------------------|---------------------------------|
| AuthController         | Login endpoint                  |
| AuthService            | Authentication orchestration    |
| UserAuthService        | Loads users for Spring Security |
| JwtUtil                | Token generation & validation   |
| JwtAuthenticationFilter| Applies JWT to requests         |
| SecurityConfig         | Security wiring                 |
