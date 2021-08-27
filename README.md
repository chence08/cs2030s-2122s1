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