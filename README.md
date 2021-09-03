## (NEW) Useful Vim and JShell commands

> How to do Lab 1 like a pro?

1. We read through the *entire* problem statement and notice we need 2 java and 1 jsh file.

2. Automatically create the required files and have them in tab view using one single command.

   ```bash
   vim -p Point.java Circle.java maxDiscCoverage.jsh
   ```

3. Use `gt` to move to the right tab, `gT` to move left.

4. Saving files

   | Action                                            | Keystroke            |
   | ------------------------------------------------- | -------------------- |
   | Save current file                                 | `:w`                 |
   | Save current file and quit                        | `:wq` OR `:x` OR `ZZ` |
   | Quit current file without saving                  | `:q!`                |
   | Save all files (that are opened in multiple tabs) | `:wa`                |
   | Save all files and quit                           | `:wqa`               |
   | Quit all files without saving any                 | `:qa!`               |

   *Note: If a new file is empty, it will not be created the first time you try to save it. For that you will need

   ```bash
   touch emptyfile
   ```

5. I want to create another file, how to do it without leaving vim?

   ```
   :tabnew AnotherClass.java
   ```
   
6. I want to open all my existing java files into tabs immediately!

   ```bash
   vim -p *.java
   ```

### Testing with JShell

```
jshell> /open Point.java 

jshell> /open Circle.java 

jshell> /open maxDiscCoverage.jsh 

jshell> Point[] points = new Point[]{new Point(0, 0), new Point(1, 0)}
points ==> Point[2] { point (0.000, 0.000), point (1.000, 0.000) }

jshell> findMaxDiscCoverage(points)
$.. ==> 2

jshell> points = new Point[]{new Point(0, -1), new Point(1, 0),
   ...> new Point(0, 1), new Point(-1, 0)}
points ==> Point[4] { point (0.000, -1.000), point (1.000, 0 ... ), point (-1.000, 0.000) }

jshell> findMaxDiscCoverage(points)
$.. ==> 4

jshell> /exit
```

You probably saw this in the Level 5 jshell testcase which was not readily provided to you as a jsh file. You can make your own level5.jsh by removing all the `jshell> ` in vim. Then, you can automate testing using:

```bash
jshell < level5.jsh
```

Notice the tests always begin with the `/open` command, if you don't load your classes **in order (superclass before subclass)**, things may go wrong that was not a result of an error in your code but rather JShell misunderstanding your input.

You can do testing without the hassle of typing out any jshell commands like this:

Your level5.jsh will now look like this without the extra commands:

```jsh
Point[] points = new Point[]{new Point(0, 0), new Point(1, 0)}
findMaxDiscCoverage(points)
points = new Point[]{new Point(0, -1), new Point(1, 0), new Point(0, 1), new Point(-1, 0)}
findMaxDiscCoverage(points)
```

```bash
jshell *.java maxDiscCoverage.jsh < level5.jsh
```

------

- [Link to the official course repository](https://github.com/nus-cs2030/2122-s1), where you earn participation through contributions to Issues and [**Wiki**](https://github.com/nus-cs2030/2122-s1/wiki), the instructions are pretty comprehensive on how to setup your local environment!

- Always take note of LumiNUS Announcements for updates!

------

Useful resources:

- (Best) Java IDE: https://www.jetbrains.com/idea/
- Java11: https://docs.oracle.com/en/java/javase/11/docs/api/
- tmux: https://gist.github.com/MohamedAlaa/2961058
- [vim guide](vimkeys.pdf)

------

(Insecure) Shortcut for easy ssh and scp

1. Download [wrapper](wrapper) into the directory you want.

2. ```bash
   chmod +x wrapper
   ```

3. Usage

   ```bash
   ./wrapper <password> ssh <server>
   ./wrapper <password> scp <source> <destination>
   ```

4. Create alias in `~/.bashrc` or `~/.zshrc` file

   ```bash
   alias cs2030ssh="./wrapper myPassword ssh e1234567@stu.comp.nus.edu.sg"
   alias cs2030scp="./wrapper myPassword scp"
   ```

5. Restart terminal or `source` your configuration file.

Note: This cannot be deployed within `stu.comp.nus.edu.sg`. If you need this to work with your plab account, you would need to use the [SoC VPN](https://webvpn.comp.nus.edu.sg/).