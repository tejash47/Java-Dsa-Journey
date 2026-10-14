# Java DSA Journey - Repository Guidelines & Agent Automation

This document outlines the operational rules and standards for maintaining the `java-dsa-journey` repository.

## Workflow for New LeetCode Problems

Whenever a LeetCode problem number (e.g., `258`) is provided:

1. **Identify the Problem**:
   - Number, exact name, difficulty, appropriate topic folder, and Java signature.
2. **Duplicate Check**:
   - Search the repository first. If it exists, report it and check its README entry.
3. **Java Solution File**:
   - Location: `<TopicFolder>/LC<Number>_<ProblemName>.java`
   - Naming: CamelCase problem name without spaces or special characters (e.g., `LC739_DailyTemperatures.java`).
   - Format:
     ```java
     /*
      * LeetCode XXX - Problem Name
      *
      * Difficulty: Easy/Medium/Hard
      * Topic: Relevant Topics
      *
      * Approach:
      * - Briefly describe the algorithm.
      *
      * Time Complexity: O(...)
      * Space Complexity: O(...)
      */

     class Solution {
         // Solution method
     }
     ```
   - Rules: Package-private `class Solution` (no `public class Solution`), Java only, no package declaration, no main method unless required, correct imports.
4. **Choose Folder**:
   - Existing topic folders: `Arrays/`, `Binary search/`, `Graphs/`, `LinkedList/`, `StackQueue/`, `Strings/`, `Trees/`, `Math/`.
   - Preserve folder names and casing. Only create new folders when strictly necessary.
5. **Update Topic README**:
   - Update `Progress` table count (`| Solved | Total |`).
   - Add entry to `Problems` table (`| # | Problem | Difficulty |`).
6. **Update Root README**:
   - Update `Progress` table topic count and total solved count.
   - Add problem to `## ✅ Solved Problems` under its topic.
   - Update `## 📈 Current Stats`.
7. **Verify & Git Push**:
   - Confirm file existence, verify syntax/compilation with `javac`, check git status.
   - Commit message: `Add LC<Number> <Problem Name> solution`
   - Push to `origin main` safely (never force push).
