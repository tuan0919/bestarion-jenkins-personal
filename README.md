# Bestarion Jenkins

Dự án Jenkins CI/CD pipeline cho Bestarion.

## Git Conventions

### 📝 Commit Message Format

Chúng ta sử dụng [Conventional Commits](https://www.conventionalcommits.org/) để đảm bảo commit messages nhất quán và có thể tự động generate changelog.

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

#### Types

- **feat**: Tính năng mới
- **fix**: Sửa lỗi
- **docs**: Thay đổi documentation
- **style**: Thay đổi formatting, missing semicolons, etc (không ảnh hưởng đến code logic)
- **refactor**: Thay đổi code không phải là fix bug hay thêm feature
- **perf**: Cải thiện performance
- **test**: Thêm hoặc sửa tests
- **chore**: Thay đổi build process, auxiliary tools, libraries
- **ci**: Thay đổi CI configuration files và scripts
- **build**: Thay đổi build system hoặc external dependencies

#### Scope (optional)

Scope có thể là:
- `jenkins`: Thay đổi liên quan đến Jenkins configuration
- `ansible`: Thay đổi liên quan đến Ansible playbooks
- `pipeline`: Thay đổi CI/CD pipeline
- `docker`: Thay đổi Docker configuration
- `security`: Thay đổi liên quan đến bảo mật

#### Ví dụ

```bash
feat(jenkins): add automated backup job for Jenkins configuration

fix(ansible): resolve inventory file permission issue

docs: update README with new deployment instructions

ci(pipeline): add security scanning step

chore(docker): update base image to latest LTS version
```

### 🌟 Branch Naming Convention

#### Branch Types

- **feature/**: Tính năng mới
  ```
  feature/jenkins-backup-automation
  feature/add-sonarqube-integration
  ```

- **bugfix/**: Sửa lỗi
  ```
  bugfix/fix-jenkins-plugin-conflict
  bugfix/ansible-permission-error
  ```

- **hotfix/**: Sửa lỗi khẩn cấp trên production
  ```
  hotfix/critical-security-patch
  hotfix/jenkins-service-crash
  ```

- **release/**: Chuẩn bị release mới
  ```
  release/v1.2.0
  release/2024-Q4
  ```

- **chore/**: Công việc maintenance
  ```
  chore/update-dependencies
  chore/cleanup-old-configs
  ```

### 🔄 Workflow

#### 1. Tạo Branch Mới

```bash
# Từ main/master branch
git checkout main
git pull origin main

# Tạo feature branch
git checkout -b feature/your-feature-name
```

#### 2. Development Process

```bash
# Stage changes
git add .

# Commit với conventional format
git commit -m "feat(jenkins): add new pipeline for microservices"

# Push branch
git push origin feature/your-feature-name
```

#### 3. Pull Request

- Tạo Pull Request với title rõ ràng
- Thêm description chi tiết về changes
- Link đến issue/ticket nếu có
- Request review từ team members
- Đảm bảo CI/CD pass

#### 4. Code Review Guidelines

**Reviewer checklist:**
- [ ] Code tuân theo coding standards
- [ ] Commit messages theo conventional format
- [ ] Tests đã được thêm/cập nhật
- [ ] Documentation được cập nhật
- [ ] Không có hardcoded credentials/secrets
- [ ] Security best practices được tuân theo

### 🚫 What NOT to do

❌ **Tránh những commit messages như:**
```bash
git commit -m "fix"
git commit -m "update"
git commit -m "changes"
git commit -m "wip"
```

❌ **Tránh commit trực tiếp vào main/master:**
```bash
# KHÔNG làm thế này
git checkout main
git commit -m "quick fix"
git push origin main
```

❌ **Tránh branch names không rõ ràng:**
```bash
# KHÔNG tốt
feature/update
bugfix/fix
test-branch
```

### 🔐 Security Guidelines

- **KHÔNG commit secrets/passwords/API keys**
- Sử dụng `.gitignore` để exclude sensitive files
- Sử dụng environment variables cho configuration
- Review code để đảm bảo không có hardcoded credentials

```bash
# Kiểm tra trước khi commit
git diff --cached

# Scan for potential secrets
git secrets --scan
```

### 📋 Pre-commit Checklist

Trước khi commit, hãy đảm bảo:

- [ ] Code đã được test locally
- [ ] Commit message tuân theo conventional format
- [ ] Không có console.log/debug statements
- [ ] Không có commented code không cần thiết
- [ ] Documentation được cập nhật nếu cần
- [ ] Secrets/credentials đã được remove

### 🛠 Useful Git Commands

```bash
# Xem history với format đẹp
git log --oneline --graph --decorate

# Amend commit message cuối cùng
git commit --amend -m "new message"

# Interactive rebase để clean up commits
git rebase -i HEAD~3

# Stash changes tạm thời
git stash push -m "work in progress"

# Apply stash
git stash pop

# Undo last commit (keeping changes)
git reset --soft HEAD~1
```

### 📚 Resources

- [Conventional Commits](https://www.conventionalcommits.org/)
- [Git Best Practices](https://git-scm.com/book/en/v2)
- [GitHub Flow](https://guides.github.com/introduction/flow/)

---

## Project Structure

```
├── ansible/          # Ansible playbooks và configurations
├── jenkins_home/      # Jenkins home directory backup
└── README.md         # Tài liệu này
```

## Getting Started

1. Clone repository
2. Đọc Git conventions trên
3. Tạo feature branch
4. Bắt đầu development
5. Tạo Pull Request

## Support

Nếu có câu hỏi về Git conventions hoặc workflow, hãy liên hệ team lead hoặc tạo issue trong repository.