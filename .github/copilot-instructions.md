# Copilot Instructions – Git Commit Convention

## 🎯 Goal
All git commit messages must follow the **Conventional Commits** specification to ensure:
- Clear change history
- Semantic versioning support
- Easy changelog generation
- Professional and consistent structure

---

## 📌 Commit Message Format

<type>(<scope>): <short summary>

[optional body]

[optional footer(s)]

---

## ✅ Allowed Types

- feat:     A new feature
- fix:      A bug fix
- docs:     Documentation changes
- style:    Code style changes (formatting, missing semicolons, etc)
- refactor: Code refactoring (no feature change, no bug fix)
- perf:     Performance improvement
- test:     Adding or updating tests
- build:    Build system or dependency changes
- ci:       CI/CD configuration changes
- chore:    Maintenance tasks
- revert:   Revert a previous commit

---

## 🧱 Rules

1. Use lowercase for type.
2. Scope is optional but recommended (e.g. auth, api, ui, core, config).
3. Summary must:
   - Be short (max ~72 characters)
   - Use imperative mood (e.g., "add", not "added" or "adds")
   - Not end with a period
4. Add body when needed to explain:
   - Why the change was made
   - What side effects might occur
5. Use footer for:
   - BREAKING CHANGE:
   - Closes #issue-number

---

## 💥 Breaking Changes

Use:

feat(auth)!: change login response structure

OR

BREAKING CHANGE: explain what changed and how to migrate

---

## 🧪 Examples

feat(auth): add JWT authentication middleware

fix(api): handle null pointer in user service

docs(readme): update installation guide

refactor(core): simplify validation logic

perf(db): optimize user query with index

test(auth): add unit tests for login service

chore(deps): upgrade express to v5

---

## 🚫 Avoid

❌ Bad:
- update code
- fix bug
- changes
- WIP
- done
- sửa lỗi

❌ Do not:
- Write commit messages in Vietnamese
- Use vague summaries
- Skip the type prefix

---

## 🧠 When Generating Commit Messages

Copilot should:
1. Detect the type based on code changes.
2. Infer scope from affected folder/module.
3. Keep summary concise and meaningful.
4. Follow the format strictly.

---

## 📦 Example Output

feat(user): add email verification flow

Add verification token generation and email sending logic.
Update user schema to include verified flag.

Closes #123