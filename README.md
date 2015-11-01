# groove-decoder

Converts Grooveshark offline `.dat` files into useable `.mp3` files.

## Installation

You need a Clojure development environment with Leiningen set up.

Download from https://github.com/turbohz/groove-decoder

Then, `lein uberjar`

## Usage

Compile an uberjar and run the resulting `.jar`, specifying the files to convert.

It will probably work with `glob` selections (`*.dat`)

    $ java -jar groove-decoder-0.1.0-standalone.jar [filenames]

## Examples

java -jar groove-decoder-0.1.0-standalone.jar 0123456789.dat

*This will create a 0123456789.mp3 file*

## Thanks

I do not take credit for the actual unscramble algorithm, which I learned from
http://lgms.nl/blog-1

## License

Copyright © 2015 TurboHz

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
