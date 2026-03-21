## Additions
- Mega Stones can now be configured (in Showdown) to allow multiple valid users.
  - If the `megaEvolves` field is a `"string"`, then it takes only that Pokemon.
  - If the `megaEvolves` field is a `["list", "of", "names"]`, then it takes any Pokemon in the list.
- Added item tags for form change items.

## Bugfixes
- Regional forms can no longer use non-regional megastones (again).
  - This fix got reverted with the 1.7 update. 