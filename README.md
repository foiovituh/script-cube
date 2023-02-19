# ScriptCube 🧊
Java manager of shell script executions. Sort your .sh files execution just by editing a cube (file containing the complete path of your scripts).

## Requirements 🔗
- Java 8+
- GNU/Linux or WSL

## Quick usage guide 📚
Create a text file with the scripts in order:
```bash
~/scripts/old_backups_cleaner.sh
~/scripts/create_new_backup.sh
~/scripts/schedule_frequent_backups.sh
```

Run .jar passing the cube path as argument:
```bash
java -jar ~/projects/script-cube/target/scriptcube-1.0-SNAPSHOT.jar \
    ~/sripts/backups-cube.txt
```

Sample response:
```bash
cube: ~/scripts/backups-cube.txt

script: ~/scripts/old_backups_cleaner.sh
timeOfLastExecution: 12:54:59.106418424

script: ~/scripts/create_new_backup.sh
timeOfLastExecution: 12:54:59.108572523

script: ~/scripts/schedule_frequent_backups.sh
timeOfLastExecution: 12:54:59.111525863
```

You can also pass --sm (stop mode) as the last argument in the jar call, this will stop the cube if any script returns a status code other than 0.

## Do you want help me? 👥
If you have any ideas or wish to contribute to the project, contact me on Twitter @vituohto or send me a pull request! :)

## License 🏳️
```
MIT License

Copyright (c) 2023 Vitu Ohto

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
